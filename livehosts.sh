#!/bin/bash

nmap $1 -n -sP | grep report | awk '{report $5}'
