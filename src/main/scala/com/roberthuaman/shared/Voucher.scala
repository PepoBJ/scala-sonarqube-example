package com.roberthuaman.shared

final case class Voucher(customerAccountNumber: String,
                         operationNumber: String,
                         currentAmount: Double,
                         withdrawalAmount: Double)
