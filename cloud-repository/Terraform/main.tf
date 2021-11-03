resource "aws_vpc" "main" {
    cidr_block = "172.17.0.0/16"
    tags = {
        Name = "AWS-Server"
    }
}

resource "aws_internet_gateway" "gw" {
    vpc_id = aws_vpc.main.id
    depends_on = [aws_vpc.main]
}

resource "aws_security_group" "allow_ssh" {
  name        = "allow_ssh"
  description = "Allow SSH inbound traffic"
  vpc_id      = aws_vpc.main.id

  ingress {
    description      = "SSH from VPC"
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    cidr_blocks      = ["0.0.0.0/0"]
    #cidr_blocks      = [aws_vpc.main.cidr_block]
    #ipv6_cidr_blocks = [aws_vpc.main.ipv6_cidr_block]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    #ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name = "allow_tls"
  }

  depends_on = [aws_vpc.main]
}

resource "aws_route_table" "my_route_table" {
  vpc_id = aws_vpc.main.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.gw.id
  }

#   route {
#     ipv6_cidr_block        = "::/0"
#     egress_only_gateway_id = aws_egress_only_internet_gateway.gw.id
#   }

  tags = {
    Name = "qqd-route-table"
  }
}

resource "aws_subnet" "my_subnet" {
  vpc_id     = aws_vpc.main.id
  cidr_block = "172.17.10.0/24"
  #availability_zone = "us-east-2"
  
  tags = {
    Name = "subnet-1"
  }
}

resource "aws_main_route_table_association" "vpc_association" {
  vpc_id = aws_vpc.main.id
  route_table_id = aws_route_table.my_route_table.id
}

resource "aws_network_interface" "net_interface" {
  subnet_id       = aws_subnet.my_subnet.id
  private_ips     = ["172.17.10.100"]
  security_groups = [aws_security_group.allow_ssh.id]
  
  tags = {
    Name = "primary_network_interface"
  }
}

resource "aws_instance" "QQD-App" {
  ami           = "ami-0233c2d874b811deb"
  instance_type = "t2.large"
  key_name      = "qqd-keypair"
  
  network_interface {
    network_interface_id = aws_network_interface.net_interface.id
    device_index         = 0
  }

  tags = {
      Name = "TerraformQQD"
  }
}

resource "aws_eip" "lb" {
  instance                  = aws_instance.QQD-App.id
  associate_with_private_ip = "172.17.10.100"
  vpc                       = true
}

# resource "null_resource" "cluster" {
#   connection {
#     type = "ssh"
#     user = "ubuntu"
#     private_key = file("./terraform.pem")
#     host = aws_eip.lb.public_ip
#   }

#   provisioner "remote-exec" {
#     inline = [
#       "echo test"
#     ]
#   }
# }