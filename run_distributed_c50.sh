#!/bin/bash

# Script to run the Distributed C5.0 implementation
# Usage: ./run_distributed_c50.sh [command] [arguments]

# Set the path to your Weka JAR file - modify this to point to your weka.jar
WEKA_JAR="/home/spyros/C50_manus_new/distributed_c50_fixed_zip/weka.jar"

# Set the path to your compiled classes
CLASSES_DIR="/home/spyros/C50_manus_new/distributed_c50_fixed_zip/out/production/distributed_c50_fixed_zip/"

# Check if WEKA_JAR path exists, if not, provide instructions
if [ ! -f "$WEKA_JAR" ]; then
    echo "Error: Weka JAR file not found at $WEKA_JAR"
    echo "Please edit this script and update the WEKA_JAR variable to point to your weka.jar file."
    exit 1
fi

# Check if classes directory exists
if [ ! -d "$CLASSES_DIR" ]; then
    echo "Warning: Classes directory not found at $CLASSES_DIR"
    echo "Make sure you have compiled the code before running this script."
    
    # Create the directory if it doesn't exist
    mkdir -p "$CLASSES_DIR"
fi

# Display usage information if no arguments provided
if [ $# -eq 0 ]; then
    echo "Usage: $0 <command> [arguments]"
    echo ""
    echo "Commands:"
    echo "  coordinator <port>                                   - Run a coordinator node"
    echo "  dataparty <nodeId> <port> <coordHost> <coordPort> [arffFile] - Run a data party node"
    echo "  test <arffFile>                                      - Run a test of the distributed C5.0 algorithm"
    echo ""
    echo "Examples:"
    echo "  $0 coordinator 9000"
    echo "  $0 dataparty party1 9001 localhost 9000 data.arff"
    echo "  $0 test iris.arff"
    exit 1
fi

# Run the program with the necessary JVM arguments
echo "Running Distributed C5.0 with command: $@"
java --add-opens java.base/java.lang=ALL-UNNAMED \
     -cp "$WEKA_JAR:$CLASSES_DIR" \
     com.distributed.c50.DistributedC50Main "$@"

# Check exit status
if [ $? -ne 0 ]; then
    echo "Error: Program execution failed."
    echo "Make sure you have compiled the code and the Weka JAR path is correct."
    echo "Current settings:"
    echo "  WEKA_JAR = $WEKA_JAR"
    echo "  CLASSES_DIR = $CLASSES_DIR"
fi
