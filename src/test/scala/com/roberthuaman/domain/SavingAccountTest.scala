package com.roberthuaman.domain

import com.roberthuaman.shared.Customer
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SavingAccountTest extends FlatSpec with Matchers {
  "SavingAccount" should "get the right amount after withdrawing" in {
    val personalAccount = Customer("71960340", "10719603407", 1200.00, operationsAllowed = true)
    val withdrawalAmount = 200.00
    val withdrawalOperation = SavingAccount.withdrawal(personalAccount, withdrawalAmount)

    withdrawalOperation._1.customerBalance shouldBe 1000.00
  }

  it should "catch the error when withdraw an amount greater than available" in {
    assertThrows[UnsupportedOperationException] {
      val personalAccount = Customer("71960340", "10719603407", 1200.00, operationsAllowed = true)
      val withdrawalAmount = 2000.00
      SavingAccount.withdrawal(personalAccount, withdrawalAmount)
    }
  }
}
