# =============================================
# azure_failover.tf – Banco de BACKUP / DR
# =============================================

resource "azurerm_resource_group" "dr" {
  name     = "${var.project_name}-dr-rg"
  location = var.azure_location
}

resource "azurerm_mssql_server" "dr" {
  name                         = "${var.project_name}-dr-server"
  resource_group_name          = azurerm_resource_group.dr.name
  location                     = azurerm_resource_group.dr.location
  version                      = "12.0"
  administrator_login          = "ocladmin"
  administrator_login_password = var.azure_sql_password
  minimum_tls_version          = "1.2"
}

resource "azurerm_mssql_database" "dr" {
  name           = "ocl-dr-db"
  server_id      = azurerm_mssql_server.dr.id
  sku_name       = "Basic"           # barato para DR
  max_size_gb    = 5
}

# Libera acesso só do teu IP ou da aplicação (em produção usar Private Endpoint)
resource "azurerm_mssql_firewall_rule" "allow_all" {
  name             = "AllowAll"
  server_id        = azurerm_mssql_server.dr.id
  start_ip_address = "0.0.0.0"
  end_ip_address   = "255.255.255.255"
}

output "azure_failover_connection_string" {
  value     = "jdbc:sqlserver://${azurerm_mssql_server.dr.fully_qualified_domain_name}:1433;database=ocl-dr-db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
  sensitive = true
}