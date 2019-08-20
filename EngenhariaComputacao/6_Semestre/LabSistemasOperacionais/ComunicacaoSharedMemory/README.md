# Comunicar dois processos através da memória compartilhada

**Enunciado:** Implemente uma solução para o seguinte problema: contar o número de ocorrências de um caracter em vetor contendo 10000 caracteres. 

O vetor deve ser gerado por um processo P1. Outros N processos, não filhos de P1, deverão contar as ocorrências do caracter em uma parte do vetor. Por exemplo, considerando um vetor de 10000 elementos e 4 processos, cada processo realizará a contagem em um subconjunto de 2500 elementos do vetor.

O processo P1 deverá: i) alocar o vetor na memória compartilhada; ii) informar o valor de N desejado (ou seja, quantos processos realizarão a contagem); e iii) informar o caracter que será contado. Após o termino da contagem realizada pelos N processos, o processo P1 deverá exibir o resultado total da contagem.

## Execução

Foram feitos dois códigos, um chamado *consumer* e outro chamado *producer*. O *producer* é o responsável por gerar o vetor e passar as informações para a memória compartilhada, enquanto o *consumer* é o responsável por acessar a memoria compartilhada, e fazer a devida contagem dos caracteres.
