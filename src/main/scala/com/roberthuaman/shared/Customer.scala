package com.roberthuaman.shared

final case class Customer(customerId: String,
                          customerAccountNumber: String,
                          customerBalance: Double,
                          operationsAllowed: Boolean)
