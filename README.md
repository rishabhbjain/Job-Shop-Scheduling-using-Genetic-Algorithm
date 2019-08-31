# Job Shop Scheduling Using Genetic Algorithm

Job Shop Scheduling is an NP-Complete scheduling problem where a combination of predefined set of jobs and machines are to be deduced. There are ‘j’ number of jobs to be run on ‘m’ number of machines in ‘o’ number of operations. The combination of jobs and machines run in an operation with the execution sequence is to be found which will result in minimum time to complete the entire process.
They cannot be formulated as a linear programming and no simple rules or algorithms
yield to optimal solutions in a short time. In this project we used Genetic Algorithm to deal with this problem of job shop scheduling.

## Constraints

This project is based on the assumptions of following constraints:
1. <i>Operations should be executed in sequence:</i>
All the available operations will be executed in a sequential manner.
2. <i>Every job should run on every machine at least once in every candidate:</i>
Each candidate has a combination of jobs and machine running in an operation. The candidate is formed in a manner that every job must be paired with every available machine at least once.
3. <i>If a job is running in the preceding operation, the same job cannot be started in the next operation:</i>
If Job 1 is still being executed in Operation 1, it cannot be started in the next operation i.e. a job cannot be run parallelly on any of the machines in any operation.
4. <i>An operation will be processed by the machine only if it is idle:</i>
The next operation will start on a machine only if the machine is idle or else, the operation will wait till the machine is idle
5.<i> No two jobs will be simultaneously processed by a machine:</i>
A machine cannot simultaneously run multiple jobs. The machine will start executing the next job only after completing execution of the previous job.
6. <i>A job cannot be simultaneously processed on multiple machines:</i>
If a job is being executed by any machine, the same job cannot be executed on any other machine.
