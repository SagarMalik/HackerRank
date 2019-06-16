#!/bin/python

import math
import os
import random
import re
import sys
from collections import defaultdict
# Complete the matchingStrings function below.
def matchingStrings(strings, queries):
  keeper=defaultdict(int);
  for st in strings:
    keeper[st]=keeper[st]+1
  return [keeper[st] for st in queries ]
  


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    strings_count = int(raw_input())

    strings = []

    for _ in xrange(strings_count):
        strings_item = raw_input()
        strings.append(strings_item)

    queries_count = int(raw_input())

    queries = []

    for _ in xrange(queries_count):
        queries_item = raw_input()
        queries.append(queries_item)

    res = matchingStrings(strings, queries)

    fptr.write('\n'.join(map(str, res)))
    fptr.write('\n')

    fptr.close()