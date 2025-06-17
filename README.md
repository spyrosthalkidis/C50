## Distributed C5.0 Algorithm for Vertically Partitioned Data

### Usage Instructions

This document provides instructions for using the distributed C5.0 implementation for vertically partitioned data.

#### Prerequisites

- Java 8 or higher
- Weka library (included in the dependencies)
- ARFF files for data input

#### System Architecture

The implementation consists of the following components:

1. **Coordinator Node**: Manages the overall distributed computation process
2. **Data Party Nodes**: Hold different vertical partitions of the data
3. **Communication Layer**: Handles secure socket-based communication between nodes
4. **Privacy Protocol Layer**: Implements the privacy-preserving protocols
5. **ARFF Handling Layer**: Processes ARFF files using Weka
6. **C5.0 Core**: Implements the distributed C5.0 algorithm

#### Running the System

The system can be run in three modes:

1. **Coordinator Mode**: Starts a coordinator node
2. **Data Party Mode**: Starts a data party node
3. **Test Mode**: Runs a test of the distributed C5.0 algorithm

##### Coordinator Mode

```
java -cp distributed-c50.jar com.distributed.c50.DistributedC50Main coordinator <port>
```

Example:
```
java -cp distributed-c50.jar com.distributed.c50.DistributedC50Main coordinator 9000
```

##### Data Party Mode

```
java -cp distributed-c50.jar com.distributed.c50.DistributedC50Main dataparty <nodeId> <port> <coordinatorHost> <coordinatorPort> [arffFile]
```

Example:
```
java -cp distributed-c50.jar com.distributed.c50.DistributedC50Main dataparty party1 9001 localhost 9000 data1.arff
```

##### Test Mode

```
java -cp distributed-c50.jar com.distributed.c50.DistributedC50Main test <arffFile>
```

Example:
```
java -cp distributed-c50.jar com.distributed.c50.DistributedC50Main test hypothyroid.arff
```

#### Privacy Preservation

The implementation uses the following privacy-preserving techniques:

1. **Secure Multiparty Computation (SMC)**: For computing information gain and other metrics without revealing raw data
2. **Homomorphic Encryption**: To perform computations on encrypted data
3. **Secure Sum Protocol**: For aggregating counts without revealing individual values
4. **Oblivious Transfer**: For secure attribute selection
5. **Zero-Knowledge Proofs**: To verify computation correctness without revealing data

#### Code Structure

- `com.distributed.c50.common`: Common constants and utilities
- `com.distributed.c50.communication`: Communication infrastructure
- `com.distributed.c50.privacy`: Privacy-preserving protocols
- `com.distributed.c50.arff`: ARFF file handling
- `com.distributed.c50.core`: Core distributed C5.0 algorithm
- `com.distributed.c50.node`: Coordinator and data party nodes
- `com.distributed.c50`: Main classes and tests

#### Building from Source

To build the project from source, use Maven:

```
mvn clean package
```

This will create a JAR file in the `target` directory.

#### Example Workflow

1. Start the coordinator node
2. Start multiple data party nodes, each with its own vertical partition of the data
3. The coordinator initiates the distributed C5.0 algorithm
4. The parties engage in secure protocols to compute information gain
5. The best attribute is selected securely
6. Data is partitioned based on the selected attribute
7. The process repeats recursively until stopping criteria are met
8. The final decision tree is constructed at the coordinator

#### References

- Vaidya, J., Clifton, C., Kantarcioglu, M., & Patterson, A. S. (2008). Privacy-preserving decision trees over vertically partitioned data. ACM Transactions on Knowledge Discovery from Data, 2(3), Article 14.
- Weka library: https://www.cs.waikato.ac.nz/ml/weka/
- C5.0 algorithm: https://github.com/uestcer/C5
