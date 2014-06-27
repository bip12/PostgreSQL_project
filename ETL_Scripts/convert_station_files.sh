#!/bin/bash
###--------------Bipul Karki, cmpe226, fall2013
###---extract and transform all the station files to csv
###---To convert setup.sh to Unix line endings on Cygwin, use dos2unix file_name.sh
  
for file in c:/cygwin/home/AWS/mesowestStationData/*
do
	python csvStation.py $file
done
if [ ! -d c:/cygwin/home/AWS/mesowestTxData/TxStationData2 ]; then
	mkdir c:/cygwin/home/AWS/mesowestTxData/TxStationData2
fi
cd c:/cygwin/home/AWS/mesowestStationData
mv *.csv c:/cygwin/home/AWS/mesowestTxData/TxStationData2


