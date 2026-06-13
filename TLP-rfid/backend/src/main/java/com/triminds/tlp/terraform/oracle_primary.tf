# =============================================
# oracle_primary.tf – Banco PRINCIPAL (produção)
# =============================================

resource "oci_database_autonomous_database" "primary" {
  admin_password           = var.db_admin_password
  compartment_id           = var.oci_compartment_id
  db_name                  = "OCLPROD"
  display_name             = "${var.project_name}-primary"
  db_workload              = "OLTP"
  data_storage_size_in_tbs = 1
  is_free_tier             = true
  license_model            = "LICENSE_INCLUDED"
  cpu_core_count           = 1
  db_version               = "19c"
}

# Output para usar no Spring Boot
output "oracle_primary_connection_string" {
  value     = oci_database_autonomous_database.primary.connection_strings.all_connection_strings["HIGH"]
  sensitive = true
}

output "oracle_wallet_download_url" {
  value = "https://objectstorage.${var.oci_region}.oraclecloud.com/n/${var.oci_compartment_id}/b/wallet/o/Wallet_OCLPROD.zip"
}