#!/usr/bin/python
###--------------Bipul Karki, cmpe226, fall2013
###--this script removes header,empty rows, padded spaces, and returns file in csv format
import csv 
import sys # to use argv

line =[]
input_file = open(sys.argv[1],'r') #argv argument for file
print input_file.name
name = input_file.name
file_reader = csv.reader(input_file, delimiter = ' ', skipinitialspace=True)
output_file = open(name+'.csv', 'wb')
file_writer = csv.writer(output_file, delimiter=',') # add comma dilimiter
header = next(file_reader) #Remove top header
#print header
del header
for row in file_reader: 	
	if any(row):
		if any('YYMMDD/HHMM' in s for s in row): #delete second header
			row=next(file_reader)
		file_writer.writerow(row)

del row
input_file.close()
output_file.close()
del output_file
