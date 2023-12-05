//design a distributed application using mpi for remeote computation where client submits an integer value to server and server returns to the client wether the integer sent is prime number or not

#include <iostream>
#include <mpi.h>
#include <cmath>

bool is_prime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= sqrt(n); ++i) {
        if (n % i == 0) return false;
    }
    return true;
}

int main(int argc, char** argv) {
    MPI_Init(&argc, &argv);

    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (size < 2) {
        std::cerr << "two processes." << std::endl;
        MPI_Abort(MPI_COMM_WORLD, 1);
    }

    if (rank == 0) {

        while (true) {
            int num;
            MPI_Recv(&num, 1, MPI_INT, MPI_ANY_SOURCE, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
            if (num == -1) {

                break;
            }

            bool prime = is_prime(num);
            MPI_Send(&prime, 1, MPI_C_BOOL, 1, 0, MPI_COMM_WORLD);
        }
    } else {

        int num;
        {
            std::cout << "enter number(integer) (or -1 to exit): ";
            std::cin >> num;

            MPI_Send(&num, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);



            bool result;
            MPI_Recv(&result, 1, MPI_C_BOOL, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
            std::cout << num << " is " << (result ? "prime" : "not prime") << std::endl;
        }
    }

    MPI_Finalize();
    return 0;
}

//mpic++ prime.cpp
//mpiexec -n 2./a.out
