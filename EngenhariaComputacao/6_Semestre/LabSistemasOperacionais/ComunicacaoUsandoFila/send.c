/*Source:
http://stackoverflow.com/questions/3056307/how-do-i-use-mqueue-in-a-c-program-on-a-linux-based-system
*/

#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <mqueue.h>

#include "common.h"

#define QUEUE_NAME  "/test_queue"
#define MAX_SIZE    1024
#define MSG_STOP    "exit"

#define SIZE_VETOR 500
#define BUSCAR_O_CARACTER 'I'

int main(int argc, char **argv){
	srand(time(NULL));
	mqd_t mq;
	//char buffer[MAX_SIZE];
	void * buffer;
	void * bufferEnviar;
	
	struct mq_attr attr;
	
	mq = mq_open(QUEUE_NAME, O_RDWR, 0644, &attr);
	CHECK((mqd_t)-1 != mq);
	
	buffer = bufferEnviar;

	//Criação do vetor de caracteres
	char vetorAleatorio[SIZE_VETOR+1];

	//Preenchimento do vetor de caracteres com algoritmos aleatórios
	for(int i = 0; i< SIZE_VETOR; i++){
		vetorAleatorio[i] = 'A' + (random() % 26);
	}
	vetorAleatorio[SIZE_VETOR] = '\0';

	//Calculo do tamanho que o buffer precisará
	int tamanhoBuffer = sizeof(char) + sizeof(int) + sizeof(vetorAleatorio);

	printf("O vetor Gerado foi: \n%s\n", vetorAleatorio);

	buffer = malloc(tamanhoBuffer);
	bufferEnviar = buffer;

	//Obtensão das informações do vetor e salvamento no buffer
	*(char*)buffer = BUSCAR_O_CARACTER; 	//Caracter a ser buscado
	buffer += sizeof(char);					//Deslocamento
	*(int*)buffer = sizeof(vetorAleatorio); //Mandando o tamanho do vetor gerado
	buffer += sizeof(int);
	sprintf(buffer, vetorAleatorio);		//Salvando o vetor aleatório

	CHECK(0 <= mq_send(mq, bufferEnviar, tamanhoBuffer, 0));
	CHECK( mq_getattr(mq, &attr) != -1);

	printf("\nEsperando resposta... \n\n");
	ssize_t bytes_read;
	bytes_read = mq_receive(mq, bufferEnviar, 1024, NULL);
	CHECK(bytes_read >= 0);

	int numeroDeCaracteres = *(int*)bufferEnviar;

	printf("A quantidade de caracteres %c encontrados no vetor foi: %d\n\n", BUSCAR_O_CARACTER, numeroDeCaracteres);
	
	/* Encerra a conexão com a fila */
	CHECK((mqd_t)-1 != mq_close(mq));
	free(bufferEnviar);
	return 0;
}
