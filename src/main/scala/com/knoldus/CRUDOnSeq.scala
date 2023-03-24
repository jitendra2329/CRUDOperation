package com.knoldus

import scala.annotation.tailrec

class CRUDOnSeq[A] extends CRUDOperation[A] {
  var sequence: Seq[A] = Seq[A]()

  def create(element: A): Seq[A] = {
    sequence = sequence :+ element
    sequence
  }

  def read(dataToFind: A): Int = {
    @tailrec
    def readHelper(dataToFind: A, index: Int): Int = {
      if (index == sequence.size - 1 && dataToFind != sequence(index))
        throw new IndexOutOfBoundsException("data not found in sequence!!") // handled in test class
      else if (dataToFind == sequence(index)) index
      else readHelper(dataToFind, index + 1)
    }

    readHelper(dataToFind, 0)
  }

  def update(indexToUpdate: Int, dataToAdd: A): Seq[A] = {
    if (indexToUpdate >= sequence.size)
      throw new IndexOutOfBoundsException("Invalid index provide!!") // handled in test class
    else {
      sequence.zipWithIndex.map {
        case (element, index) => if (index == indexToUpdate) dataToAdd else element
      }
    }
  }

  def delete(dataToDelete: A): Seq[A] = {
    if (sequence.contains(dataToDelete)) {
      sequence = sequence.filterNot(_ == dataToDelete)
      sequence
    } else throw new NoSuchElementException("Data not present in the sequence!")

  }
}
