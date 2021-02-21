package com.roberthuaman.domain

import com.roberthuaman.shared.{Customer, Voucher}

import java.util.UUID.randomUUID

object SavingAccount {
  def withdrawal(naturalPerson: Customer, withdrawalAmount: Double): (Customer, Voucher) = {
    if (!naturalPerson.operationsAllowed || naturalPerson.customerBalance < withdrawalAmount) {
      throw new UnsupportedOperationException
    }

    val operationNumber = randomUUID().toString
    val remainingBalanceAmount = naturalPerson.customerBalance - withdrawalAmount

    val voucherGenerated = Voucher(naturalPerson.customerAccountNumber,
      operationNumber,
      naturalPerson.customerBalance,
      withdrawalAmount)

    val naturalPersonUpdate = Customer(naturalPerson.customerId,
      naturalPerson.customerAccountNumber,
      remainingBalanceAmount,
      naturalPerson.operationsAllowed)

    (naturalPersonUpdate, voucherGenerated)
  }
}
