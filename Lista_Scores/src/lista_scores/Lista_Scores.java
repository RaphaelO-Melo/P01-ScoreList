// Este programa foi desenvolvido por Raphael Oliveira Melo e Gabriel Alves Freitas Almeida
// Tecnologia em Jogos Digitais I - Centro Universitário SENAC - 2018


package lista_scores;
//Importando bibliotecas:
import java.util.Scanner;
public class Lista_Scores{
  public static void main( String args[]){
    
// Definindo variáveis:
    Scanner entrada = new Scanner(System.in);
    
// Variáveis principais (Opção do usuário, Vetor, Tamanho do vetor, Contador padrão:
    int opc=0, vetor[] = new int [99], quantvtr=0, Cont;
// Variáveis da operação 2 (Número que será adicionado, Posição em que será adicionado, Resposta que voltará da função):
    int num, posi, respfun2;
// Variáveis da operação 3 (A posição em que terá o score removido):
    int remov;    
// Variáveis da operação 4 (Número que será removido, Contador para a remoção): 
    int numremov, contfun4;
// Variáveis da operação 5 (O número que o programa vai procurar):
    int scan5;
// Variáveis da operação 6 (Onde o maior número será guardado toda que que superar o atual):
    int maior = 0;
// Variáveis da operação 7 (Onde o retorno da função será guardado):
    int soma=0;
// Variáveis da operção 8 (Número a ser comparado, Resposta da função auxiliar):
    int conf8, respfun8;

    
    
// Loop principal, que reinicia o programa
    while (opc != 9){
      
// Reseta a contagem das posições
      
      Cont = 0;
      
      System.out.println ("1. Adicionar uma pontuação no final da lista de scores; ");
      System.out.println ("2. Adicionar uma pontuação em uma dada posição na lista de scores;");
      System.out.println ("3. Remover uma pontuação de uma dada posição na lista de scores;");
      System.out.println ("4. Remover todas as ocorrências de uma pontuação na lista de scores;");
      System.out.println ("5. Verificar se uma pontuação está contida lista de scores; ");
      System.out.println ("6. Buscar a maior pontuação na lista de scores; ");
      System.out.println ("7. Calcular a soma total de pontuação na lista de scores");    
      System.out.println ("8. Verificar se dado uma pontuação existem duas pontuações na lista de scores que somadas são iguais à pontuação informada");
      System.out.print ("Escolha uma opção:");
      System.out.println("");
      opc = entrada.nextInt();
      
      
// Executa função 1
      if (opc == 1){
        if (quantvtr == 99){
        System.out.println ("Quantidade de Scores excedida!");
        }
        System.out.print ("Que score deseja adicionar?");
        vetor [quantvtr] = entrada.nextInt();
        quantvtr++;
      }  
      
// Executa função 2
      if (opc == 2){
        System.out.print ("Que Score deseja adicionar?");
        num = entrada.nextInt();
        System.out.print ("Em que posição? (0 a 99)"); 
        posi = entrada.nextInt();
        respfun2 = fun2 (vetor, quantvtr, num, posi);
        
        if (respfun2==1){
          System.out.println ("Posição inválida!");
        }
        quantvtr++;
      }   
      
// Executa função 3
      if (opc == 3){
        System.out.print ("Em que posição deseja remover? (0 a 99)"); 
        remov = entrada.nextInt();
        vetor[remov]=0;
        funmov (vetor, quantvtr,remov);
        quantvtr--;
      }  
      
// Executa função 4
      if (opc==4){
        System.out.print("Que Score deseja remover?");
        numremov = entrada.nextInt();
        contfun4 = quantvtr;
        while(contfun4 >= 0){
          if (vetor[contfun4] == numremov){
            vetor[contfun4] = 0;
            funmov (vetor, quantvtr, contfun4);
            quantvtr--;
          }
          contfun4--;
        }
      }
      
// Executa função 5
      if (opc==5){
        System.out.print("Que Score deseja conferir?");
        scan5 = entrada.nextInt(); 
        for (Cont = 0;Cont <= quantvtr; Cont++){          
          if (vetor[Cont] == scan5){
            System.out.println("Sim, esse Score está inserido na lista.");
            Cont = quantvtr;
          }
          else if (Cont == quantvtr && vetor[Cont] != scan5 ){
            
            System.out.println("Não, esse Score não está inserido na lista.");
          }
        }
      }
// Executa função 6 
      if (opc == 6){
        for (Cont = 0;Cont < quantvtr; Cont++){
          if (vetor[Cont] > maior)
            maior = vetor[Cont];
        }
        System.out.println("Seu maior Score é: "+maior+"."); 
      }
      
// Executa função 7
      if (opc == 7){
        soma=0;
        for (Cont = 0;Cont <= quantvtr; Cont++){          
          soma = vetor[Cont]+soma;
        }
        System.out.println("A soma total dos Scores na sua lista é: "+soma+".");
      }          
// Executa função 8
      if (opc == 8){
        System.out.println("Informe o Score a ser conferido:");
        conf8 = entrada.nextInt();
        respfun8 = fun8 (vetor, quantvtr, conf8);
        
        if (respfun8 == 1){
          System.out.println("Sim, existe essa possíbilidade");
        }
        else
          System.out.println("Não existe essa possíbilidade");
      }
//Exibe os Scores
      System.out.println("Sua lista de Scores atual é:"); 
      for (Cont = 0;Cont < quantvtr; Cont++){          
        System.out.println("Score("+Cont+"):" +vetor[Cont]+";");
        
        
      }
    }
  }
  
// Funções secundárias
  
// Função ligada à 2ª operação 
  public static int fun2 (int v[], int tam, int numero, int posicao){
    int temp1, temp2,i=posicao;
    if (v[posicao] != 0){
      temp1= v[posicao];
      v[posicao] = numero;
      
      while (i <= tam){
        i++;
        temp2= v[i];
        v[i] = temp1;
        i++;
        temp1= v[i];
        v[i] = temp2;
      }
    }
    else if (posicao > tam){
      return 1;
    }
    return 0;
  }
  
  
// Função ligada à 3ª operação
  
  public static void funmov (int v[], int tam, int coord){
    int n=0, i=coord+1, temp;
    
    while(coord<tam){
      v[coord] = v[i];
      coord++;
      i++;
    }    
  }
 
// Função ligada à 8ª operação
  public static int fun8(int vet[], int ref, int alvo){
    int a, b;
    
    for (a=0; a < ref-1; a++){
      
      for( b=0;b<ref-1; b++){
        if(vet[a]+vet[b]==alvo){
          return 1;
        }
      }
      b = 0;
    }
    return 0;
  }
}

