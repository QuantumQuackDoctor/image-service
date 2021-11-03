pipeline {
    agent any
    tools {
        terraform 'terraform'
    }
    stages {
        stage('Terraform Init') {
            steps {
                dir('Terraform') {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform Plan') {
            steps {
                dir('Terraform') {
                    sh 'terraform plan'
                }
            }
        }
        stage('Terraform Apply') {
            steps {
                dir('Terraform') {
                    sh 'terraform apply -auto-approve'
                }
            }
        }
        // stage('Terraform Destroy') {
        //     steps {
        //         dir('Terraform') {
        //             sh 'terraform destroy -auto-approve'
        //         }
        //     }
        // }
        stage('Route53') {
            steps {
                dir('Ansible') {
                    sh 'ansible-galaxy collection install community.aws'
                    sh 'ansible-playbook Route53Playbook.yml'
                }
            }

        }
        // stage('CloudFront') {
        //     steps {
        //         //sh 'ansible-playbook S3BucketDeploy.yml'
        //     }

        // }
    }
}