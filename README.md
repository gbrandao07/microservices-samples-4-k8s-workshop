# microservices-samples-4-k8s-workshop

Projeto utilizado em um workshop que apresentei sobre "Introdução ao Kubernetes".
Constitui-se de dois projetos em Spring Boot, chamados "microservice-helloworld" e "microservice-welcome"
São microserviços que expõem endpoints rest. Projetos do tipo "exemplos" apenas com os insumos necessários para entender como o Kubernetes gerencia aplicações.

## microservice-helloworld

Projeto que será a porta de entrada para requisições externas. 
Durante o processamento da requisição externa, irá invocar o "microservice-welcome", realizar um processamento e devolver a resposta ao cliente.

## microservice-welcome

Projeto que ficará disponível apenas para receber requisições de serviços de dentro do cluster. Ou seja, irá receber requisições do "microservice-helloworld" mas no será capaz de receber requisições externas ao cluster.

## Visão detalhada do cenário do workshop
![alt text](https://github.com/gbrandao07/microservices-samples-4-k8s-workshop/blob/master/diagram-demo.png?raw=true)

## Requisitos para o exercício do workshop

- JDK 8 ou superior
- Docker
- Minikube ou cluster K8s 

## Comandos úteis

### Minikube

- Utilizar Minikube como repositório Docker (elimina necessidade de fazer "push" das imagens para um repositório externo, como o Dockerhub)
```
minikube docker-env
eval $(minikube -p minikube docker-env)
```

### Docker

- Build dos projetos
```
docker build -t microservice-welcome:v1 .
docker build -t microservice-helloworld:v1 .
```

### Kubernetes

Observação: alguns comandos abaixo utilizam-se das flags:<br>
--dry-run: valida se o comando é válido, porém não efetua a alteração no cluster.<br>
-o yaml: exibe o resultado do comando no formato yaml. Útil para atender necessidades de "Infra as Code"<br>
Ou seja, caso queira efetuar a alteração no cluster, retire estas flags.

- Criar deployments 
```
kubectl run microservice-welcome --image=microservice-welcome:v1 --dry-run -o yaml
kubectl run microservice-helloworld --image=microservice-helloworld:v1 --dry-run -o yaml
```
- Criar/expor deployments como serviços
```
kubectl expose deploy microservice-helloworld --name=microservice-helloworld --port=80 --type=ClusterIp --dry-run -o yaml
kubectl expose deploy microservice-welcome --name=microservice-welcome --port=80 --type=ClusterIp --dry-run -o yaml
```
- Logs e informações
```
kubectl describe <recurso> 
kubectl logs <pod>
```
