#!/bin/bash
###--------------Bipul Karki, cmpe226, fall2013
###---extract and transform all the station files to csv  
###---To convert setup.sh to Unix line endings on Cygwin, use dos2unix file_name.sh

for file in c:/cygwin/home/AWS/mesowestWeatherData/*
do
	python csvWeather.py $file
done
if [ ! -d c:/cygwin/home/AWS/mesowestTxData/TxWeatherData ]; then
	mkdir c:/cygwin/home/AWS/mesowestTxData/TxWeatherData
fi
cd c:/cygwin/home/AWS/mesowestWeatherData
mv *.csv c:/cygwin/home/AWS/mesowestTxData/TxWeatherData


