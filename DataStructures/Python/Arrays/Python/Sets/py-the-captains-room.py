#!/bin/python3

# https://www.hackerrank.com/challenges/py-the-captains-room/problem
# Author : Sagar Malik (sagarmalik@gmail.com)

k = int(input())
all_rooms = input().split()
unique_rooms = set()
unique_keeper = set()
for room in all_rooms:
  if room not in unique_rooms:
    unique_rooms.add(room)
    unique_keeper.add(room)
  else:
    unique_keeper.discard(room)
    
print(*unique_keeper)
