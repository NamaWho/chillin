# Chillin App
The Chillin App is a mobile application that allows users to record their heart rate and gps data, allowing users to monitor their stress during their daily operations. The app is designed to be used in conjunction with the Chillin Wearable Device, which is a wearable device that measures heart rate and gps. The app allows users to record their data and view it in real-time.
<hr>

## 1. Data Exchange Format
In order to reduce the complexity of the data exchange process, the data exchange format is defined. The data exchange format is a simple byte array that contains the following fields:
- **Timestamp**: The timestamp of the recorded data in milliseconds. [Long]
- **Heart Rate Sensor Value**: The heart rate sensor value in beats per minute. [Float]
- **GPS Sensor Value**: The GPS sensor value converted to a Double value (latitude and longitude). [Double]

The data exchange format is defined as follows:
```
| Timestamp (8 bytes) | Heart Rate Sensor Value (4 bytes) | GPS Sensor Value (8 bytes) |
```
for a total of 20 bytes.
In order to perform fewer data exchange, it has been decided to send 30 seconds of data at a time (bulk data). This means that the data exchange format will be repeated 30 times, for a total of 600 bytes.
