# =============================================
# main.tf – Variáveis e Providers
# =============================================

terraform {
  required_version = ">= 1.5.0"
  required_providers {
    oci = {
      source  = "oracle/oci"
      version = ">= 5.0"
    }
    azurerm = {
      source  = "hashicorp/azurerm"
      version = ">= 3.0"
    }
  }
}

# ---------- Oracle Cloud (Provider Principal) ----------
provider "oci" {
  tenancy_ocid     = var.oci_tenancy_ocid
  user_ocid        = var.oci_user_ocid
  fingerprint      = var.oci_fingerprint
  private_key_path = var.oci_private_key_path
  region           = var.oci_region
}

# ---------- Azure (Provider Failover / DR) ----------
provider "azurerm" {
  features {}
  subscription_id = var.azure_subscription_id
  client_id       = var.azure_client_id
  client_secret   = var.azure_client_secret
  tenant_id       = var.azure_tenant_id
}

# Variáveis comuns (podes colocar em variables.tf ou terraform.tfvars)
variable "oci_region"            { type = string  default = "eu-madrid-1" }
variable "azure_location"        { type = string  default = "West Europe" }
variable "project_name"          { type = string  default = "ocl-logistics" }