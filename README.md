# CRUDOperation

# Assignment => Create an abstract class "CRUD operations" having 4 methods - create, read, update, delete. Create 2 classes and extend both of them with "CRUD operations" abstract class - one class would be using list to perform CRUD operations and the other class would be using seq to perform CRUD operations.

# I have added one additional method called find, which will find the data into the collection(List or Seq)

    This assignment contains Three source files and two test file. One Generic abstract class file, one CRUDOnList and one CRUDOnSeq.
    the abstract clsss contains five abstract methods (create, update, read, find and delete). The implementation of the abstract methods are
    in CRUDOnList which will work on Int type.
    In CRUDOnSeq file the implementation is on String type.
               
               ->  create method will add elements to the Empty List and return the List 
               
               ->  find method will take a data to be find in the list and if the data is found in the list then the index of that 
                   element will be returned, if data is not present in the list then it will throw an exception and that exception 
                   will be cought in test class.
                   
               ->  update method will take two parameter (index where data is to be updated and data), after updating the Seq, it will
                   return the Seq
                   
               -> delete method will take a parameter (data to be deleted) and after deletion, it will return the Seq
               
               -> read method will simply return the hole List or Seq 
               
               
               
