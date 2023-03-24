package com.knoldus

//Generic abstract class
/*
                                    ***
     Giving the return type of some methods in abstract class CRUDOperation as Seq[A],
     because List is sub-type of Seq.
     So if give the return type as Seq then it can return a List also.
                                    ***
     => I have made one more method called find, for finding the data from the list of sequence <=
 */
abstract class CRUDOperation[A] {
  def create(element: A): Seq[A]

  def read(): Seq[A]

  def update(index: Int, dataToAdd: A): Seq[A]

  def delete(dataToDelete: A): Seq[A]

  def find(dataToFind: A): Int
}
