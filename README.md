# Scala Exception Handling Bug

This repository demonstrates a common error in Scala when dealing with exceptions, Options, and Lists. The `bug.scala` file contains code that attempts to perform division, catching exceptions with `Try`, but fails to properly handle the resulting `Option` within a list, leading to a runtime exception.

The `bugSolution.scala` file provides a corrected version, showcasing how to robustly handle potential exceptions and manage `Option` types effectively within list operations.

## Problem
The initial code uses `Try` to safely perform division, resulting in a List of `Option[Int]`.  However, it fails to correctly manage `None` values within that list, which causes an exception when trying to access `.get` on the result.