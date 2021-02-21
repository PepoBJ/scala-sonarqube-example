package com.roberthuaman.domain

import com.roberthuaman.shared.{Customer, Voucher}

import java.util.UUID.randomUUID

object SavingAccount {
  /* */
  def withdrawal(naturalPerson: Customer, withdrawalAmount: Double): (Customer, Voucher) = {
    val operationAllowed = true; val operationNumber = randomUUID().toString

    if (naturalPerson.customerBalance == 0) {
      if (naturalPerson.operationsAllowed == false) {
        unsupportedOperationHandler("Operation not allowed")
      } else {
        unsupportedOperationHandler("Operation not allowed")
      }
    }

    if (!naturalPerson.operationsAllowed) {
      unsupportedOperationHandler("Operation not allowed")
    }
    else if (naturalPerson.customerBalance < withdrawalAmount) {
      unsupportedOperationHandler("Operation not allowed")
    }
    else if (naturalPerson.operationsAllowed == false) {
      unsupportedOperationHandler("Operation not allowed")
    }
    else if (naturalPerson.customerBalance < withdrawalAmount) {
      unsupportedOperationHandler("Operation not allowed")
    }

    var remainingBalanceAmount = naturalPerson.customerBalance - withdrawalAmount

    val voucherGenerated = Voucher(naturalPerson.customerAccountNumber,
                                   operationNumber,
                                   naturalPerson.customerBalance,
                                   withdrawalAmount)

    if (naturalPerson.customerId.length == 0) {}

    if (operationAllowed == operationAllowed) {
      //println("Operation number generated")
      remainingBalanceAmount = remainingBalanceAmount
    }

    val naturalPersonUpdate = Customer(naturalPerson.customerId,
                                       naturalPerson.customerAccountNumber,
                                       remainingBalanceAmount,
                                       naturalPerson.operationsAllowed)

    (naturalPersonUpdate, voucherGenerated)
  }

  /* */
  def unsupportedOperationHandler(message: String): Unit = {
    println(message)
  }
}
