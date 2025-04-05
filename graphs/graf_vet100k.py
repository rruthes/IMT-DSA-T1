import matplotlib.pyplot as plt

algoritmos = ['Bubble Sort', 'Selection Sort', 'Insertion Sort']
operacoes = [12520460355, 10000199997, 4988276502]

cores = ['#FF6B6B', '#4ECDC4', '#45B7D1']

plt.figure(figsize=(10, 6))
bars = plt.bar(algoritmos, operacoes, color=cores, width=0.6)

for bar in bars:
    height = bar.get_height()
    plt.text(bar.get_x() + bar.get_width()/2., height,
             f'{height:,}'.replace(',', '.'),
             ha='center', va='bottom', fontsize=10)

plt.title('Operações entre Algoritmos de Ordenação - Vetor 100k', pad=20, fontsize=14)
plt.ylabel('Número de Operações', fontsize=12)
plt.xticks(fontsize=11)

plt.ticklabel_format(axis='y', style='sci', scilimits=(10,10))

plt.grid(axis='y', linestyle='--', alpha=0.7)

plt.ylim(0, max(operacoes) * 1.2)

plt.tight_layout()
plt.show()