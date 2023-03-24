package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.{an, be}

class CRUDOnSeqTest extends AnyFlatSpec {
  val sequenceCRUDOperation = new CRUDOnSeq[String]

  it should "return the Seq[Int]" in {
    sequenceCRUDOperation.create("Jitendra")
    sequenceCRUDOperation.create("Ravi")
    sequenceCRUDOperation.create("Akash")
    sequenceCRUDOperation.create("Ajit")
    sequenceCRUDOperation.create("Pallav")
    val actualSequence = sequenceCRUDOperation.create("Bhavya")
    val expectedSequence = Seq("Jitendra", "Ravi", "Akash", "Ajit", "Pallav", "Bhavya")
    assert(actualSequence == expectedSequence)
  }

  it should "return index where data is found in the Seq" in {
    val dataToFind = "Bhavya"
    val actualIndex = sequenceCRUDOperation.read(dataToFind)
    val expectedIndex = 5
    assert(actualIndex == expectedIndex)
  }

  it should "throw an IndexOutOfBoundException, in case data to be found is not present in the Seq " in {
    an[IndexOutOfBoundsException] should be thrownBy {
      sequenceCRUDOperation.read("Manish")
    }
  }

  it should "return the updated Seq " in {
    val indexToUpdate = 3
    val dataToUpdate = "Manish"
    val actualResult = sequenceCRUDOperation.update(indexToUpdate, dataToUpdate)
    val expectedResult = Seq("Jitendra", "Ravi", "Akash", "Manish", "Pallav", "Bhavya")
    assert(actualResult == expectedResult)

  }

  it should "throw an exception IndexOutOfBoundException, when given index is greater than or equal to Seq size" in {
    val index = 6
    val dataToUpdate = "Prateek"
    an[IndexOutOfBoundsException] should be thrownBy {
      sequenceCRUDOperation.update(index, dataToUpdate)
    }
  }

  /* test case for deleting the data from the list,
     the delete method will return the updated list after deleting the data from the list
    */
  it should "return the updated Seq after deleting data from Seq" in {
    val dataToDelete = "Pallav"
    val actualResult = sequenceCRUDOperation.delete(dataToDelete)
    val expectedResult = Seq("Jitendra", "Ravi", "Akash", "Ajit", "Bhavya")
    assert(actualResult == expectedResult)
  }

  // In case data is not in the Seq
  it should "throw an exception NoSuchElementException, data is not in the Seq" in {
    val dataToDelete = "Ram"
    an[NoSuchElementException] should be thrownBy {
      sequenceCRUDOperation.delete(dataToDelete)
    }
  }

}
