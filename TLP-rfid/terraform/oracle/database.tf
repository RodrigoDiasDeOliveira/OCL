resource "azurerm_kubernetes_cluster" "ocl_cluster" {
  name                = "ocl-cluster"
  location            = var.location
  resource_group_name = var.resource_group

  default_node_pool {
    name       = "default"
    node_count = 2
    vm_size    = "Standard_B2s"
  }

  identity {
    type = "SystemAssigned"
  }
}