terraform {
  required_providers {
      aws = {
          source = "hashicorp/aws"
          version = "~> 3.0"
      }
  }
}

#Configure the AWS provider
provider "aws" {
    region = "us-east-2"
    //shared_credentials_file = "/Users/tf_user/.aws/creds"
}