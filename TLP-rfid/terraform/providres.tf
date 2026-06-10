provider "oci" {
  tenancy_ocid     = var.oci_tenancy
  user_ocid        = var.oci_user
  fingerprint      = var.oci_fingerprint
  private_key_path = var.oci_private_key
  region           = "eu-frankfurt-1"
}

provider "azurerm" {
  features {}
}