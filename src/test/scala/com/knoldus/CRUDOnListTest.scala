package com.knoldus
import org.scalatest.matchers.must.Matchers.{an, be}
import org.scalatest.flatspec.AnyFlatSpec

class CRUDOnListTest extends AnyFlatSpec {

  val listCRUDOperation = new CRUDOnList[Int]

  // test case for creating the List
  it should "return the List[Int]" in {
    listCRUDOperation.create(2)
    listCRUDOperation.create(5)
    listCRUDOperation.create(10)
    listCRUDOperation.create(62)
    listCRUDOperation.create(16)
    val actualList = listCRUDOperation.create(69)
    val expectedList = List(69, 16, 62, 10, 5, 2)
    assert(actualList == expectedList)
  }

  //test case for reading the List
  it should "return index where data is found in the List" in {
    val dataToFind = 16
    val actualIndex = listCRUDOperation.read(dataToFind)
    val expectedIndex = 1
    assert(actualIndex == expectedIndex)
  }

  //test case for reading the list, in case data to found is not in the list
  it should "throw an IndexOutOfBoundException, in case data to be found is not present in the List " in {
    an[IndexOutOfBoundsException] should be thrownBy {
      listCRUDOperation.read(20)
    }
  }

    //test case for updating the list on any given position
    it should "return the updated list " in {
      val indexToUpdate = 3
      val dataToUpdate = 91
      val actualResult = listCRUDOperation.update(indexToUpdate,dataToUpdate)
      val expectedResult = List(69,16,62,91,5,2)
      assert(actualResult == expectedResult)

    }

  //test case for updating the list, in case the index where the is to be update, is out of bound
  // index >= size of the list
  it should "throw an exception IndexOutOfBoundException " in {
    val index = 6
    val dataToUpdate = 100
    an[IndexOutOfBoundsException] should be thrownBy {
      listCRUDOperation.update(index,dataToUpdate)
    }
  }

   /* test case for deleting the data from the list,
      the delete method will return the updated list after deleting the data from the list
     */
  it should "return the updated list after deleting data from list" in {
    val dataToDelete = 2
    val actualResult = listCRUDOperation.delete(dataToDelete)
    val expectedResult = List(69, 16, 62, 10, 5)
    assert(actualResult == expectedResult)
  }

  // In case data is not in the List
  it should "throw an exception NoSuchElementException " in {
    val dataToDelete = 100
    an[NoSuchElementException] should be thrownBy {
      listCRUDOperation.delete(dataToDelete)
    }
  }
 }

