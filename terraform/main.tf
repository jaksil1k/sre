provider "aws" {
  region = "eu-central-1"

}


resource "aws_instance" "my_Ubuntu" {
  ami           = "ami-06dd92ecc74fdfb36"
  instance_type = "t2.micro"
  tags = {
    Name    = "My Ubuntu Server"
  }
}