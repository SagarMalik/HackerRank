#!/bin/python3

# https://www.hackerrank.com/challenges/py-check-subset/problem
# Author : Sagar Malik (sagarmalik@gmail.com)

n = int(input())
for _ in range(n):
  K = int(input())
  first = set(input().split())
  t = int(input())
  second = set(input().split())
  print(len(first-second) == 0)
