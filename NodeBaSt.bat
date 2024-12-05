@echo off
cd C:\Users\Dandelion\Documents\NodeBaSt
javac -d build\classes -Xlint:unchecked .\src\Nodes\Node.java .\src\Nodes\DoubleNode.java .\src\Nodes\BinaryNode.java .\src\LinkedArrays\List.java .\src\LinkedArrays\DoubleList.java .\src\LinkedArrays\Stack.java .\src\LinkedArrays\Queue.java .\src\Trees\BinaryTree.java .\src\Trees\BinarySearchTree.java .\src\Trees\AVLTree.java .\src\Mechanics\Main\Test.java
java -cp build\classes; Mechanics.Main.Test
pause