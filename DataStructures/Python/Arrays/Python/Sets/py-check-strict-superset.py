#!/bin/python3

# https://www.hackerrank.com/challenges/py-check-strict-superset/problem
# Author : Sagar Malik (sagarmalik@gmail.com)
main_set = set(input().split())
n = int(input())
do_loop = True

while n > 0 and do_loop:
  individual_set = set(input().split())
  do_loop &= main_set > individual_set
  n-=1

print(do_loop)
