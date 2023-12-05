

#include <iostream>
#include <mpi.h>
using namespace std;


int calculateFactorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * calculateFactorial(n - 1);
    }
}

int main(int argc, char** argv) {
    MPI_Init(&argc, &argv);

    int world_size, rank;

    MPI_Comm_size(MPI_COMM_WORLD, &world_size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if (world_size < 2) {
        cout << "This program requires at least 2 processes." << endl;
        MPI_Abort(MPI_COMM_WORLD, 1);
    }

    if (rank == 0) {
        
        
        
        int client_value;
        MPI_Status status;

        MPI_Recv(&client_value, 1, MPI_INT, 1, 0, MPI_COMM_WORLD, &status);

        int factorial_result = calculateFactorial(client_value);

        MPI_Send(&factorial_result, 1, MPI_INT, 1, 1, MPI_COMM_WORLD);

    } else if (rank == 1) {
        
       
        int client_value = 5;  

        MPI_Send(&client_value, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);

        int factorial_result;
        MPI_Status status;
        MPI_Recv(&factorial_result, 1, MPI_INT, 0, 1, MPI_COMM_WORLD, &status);

        cout << "Factorial result received from server: " << factorial_result << endl;
    }

    MPI_Finalize();
    return 0;
}

