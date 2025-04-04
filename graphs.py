import matplotlib.pyplot as plt
import numpy as np

# Dados das baterias de testes (extraídos dos exemplos)
baterias = [
    # Bateria 1
    {
        "tamanho": [1600000, 1089375, 1225986],
        "bubble_sort": [640322362974, 1068518724525, 639342438183],
        "selection_sort": [640116362452, 1069145557361, 640183033945],
        "insertion_sort": [639729230982, 1068604662039, 640142184058],
        "busca_linear": [40, 33, 37],
        "busca_binaria": [42, 42, 42],
    },
    # Bateria 2 (adicionar outras baterias conforme necessário)
]

# Função para plotar comparação entre algoritmos de ordenação
def plot_ordenacao(bateria):
    tamanhos = bateria["tamanho"]
    bubble = [op / 1e9 for op in bateria["bubble_sort"]]  # Convertendo para bilhões
    selection = [op / 1e9 for op in bateria["selection_sort"]]
    insertion = [op / 1e9 for op in bateria["insertion_sort"]]
    
    x = np.arange(len(tamanhos))
    width = 0.25
    
    fig, ax = plt.subplots(figsize=(10, 6))
    rects1 = ax.bar(x - width, bubble, width, label='Bubble Sort (bilhões)')
    rects2 = ax.bar(x, selection, width, label='Selection Sort (bilhões)')
    rects3 = ax.bar(x + width, insertion, width, label='Insertion Sort (bilhões)')
    
    ax.set_ylabel('Operações (em bilhões)')
    ax.set_title('Comparação de Algoritmos de Ordenação')
    ax.set_xticks(x)
    ax.set_xticklabels([f"{size:,}" for size in tamanhos])
    ax.legend()
    
    plt.tight_layout()
    plt.show()

# Função para plotar comparação entre algoritmos de busca
def plot_busca(bateria):
    tamanhos = bateria["tamanho"]
    linear = bateria["busca_linear"]
    binaria = bateria["busca_binaria"]
    
    x = np.arange(len(tamanhos))
    width = 0.35
    
    fig, ax = plt.subplots(figsize=(10, 6))
    rects1 = ax.bar(x - width/2, linear, width, label='Busca Linear')
    rects2 = ax.bar(x + width/2, binaria, width, label='Busca Binária')
    
    ax.set_ylabel('Número de Operações')
    ax.set_title('Comparação de Algoritmos de Busca')
    ax.set_xticks(x)
    ax.set_xticklabels([f"{size:,}" for size in tamanhos])
    ax.legend()
    
    plt.tight_layout()
    plt.show()

# Gerar gráficos para a primeira bateria de testes
plot_ordenacao(baterias[0])
plot_busca(baterias[0])