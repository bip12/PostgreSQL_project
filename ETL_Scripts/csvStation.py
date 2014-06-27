#!/usr/bin/python
###--------------Bipul Karki, cmpe226, fall2013
###--this script removes header, spaces, few unnecessary columns, INACTIVE station rows, and returns file in csv format
import csv
import sys # to use arg

input_file = open(sys.argv[1],'rb') # pass input file from cmd line
print input_file.name
name = input_file.name
file_reader = csv.reader(input_file, delimiter = ',', skipinitialspace=True)
output_file = open(name+'.csv', 'wb')
file_writer = csv.writer(output_file)
header = next(file_reader) #Remove top header
#print header
del header

for row in file_reader: 
	if 'E3414' not in row [0]: # E3414 contains non ascii character
		if (row[5] == "NULL" or row[5] == ""):
			row[5] = 0.0
		if (row[6] =="NULL" or ""):
			row[6] = 0.0
		if (row[7] =="NULL" or ""):
			row[7] = 0.0
		if (row [10] == ''):
			row[10]= 'INACTIVE'
		file_writer.writerow(row[0:11])

del row
input_file.close()
output_file.close()
del output_file
