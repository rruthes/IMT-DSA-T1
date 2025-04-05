import matplotlib.pyplot as plt
import numpy as np

plt.style.use('seaborn-v0_8-darkgrid')
plt.figure(figsize=(12, 7))

tamanhos = np.array([100000, 200000, 400000, 800000])  # Em milhares
tamanhos_labels = ['100k', '200k', '400k', '800k']

algoritmos = {
    'Bubble Sort': np.array([12520460355, 50015803531, 200055352311, 800027100139], dtype=np.int64),
    'Selection Sort': np.array([10000199997, 40000399997, 160000799997, 640001599997], dtype=np.int64),
    'Insertion Sort': np.array([4988276502, 19996897498, 79975798464, 320333535076], dtype=np.int64)
}

cores = {
    'Bubble Sort': '#E63946',
    'Selection Sort': '#457B9D',
    'Insertion Sort': '#2A9D8F'
}

marcadores = {
    'Bubble Sort': 'o',
    'Selection Sort': 's',
    'Insertion Sort': '^'
}

fig, ax = plt.subplots()

for nome, dados in algoritmos.items():
    ax.plot(tamanhos, dados, f'{marcadores[nome]}-', 
            color=cores[nome], linewidth=2.5, 
            markersize=8, label=nome)

    for x, y in zip(tamanhos, dados):
        ax.annotate(f'{y:.2e}', (x, y), 
                   textcoords="offset points", 
                   xytext=(0,10), ha='center', 
                   fontsize=9, color=cores[nome])

ax.set_title('Complexidade de Algoritmos de Ordenação', 
             pad=20, fontsize=16, fontweight='bold')
ax.set_xlabel('Tamanho da Entrada', fontsize=12)
ax.set_ylabel('Número de Operações (escala log)', fontsize=12)
ax.set_xticks(tamanhos)
ax.set_xticklabels(tamanhos_labels)
ax.set_yscale('log')
ax.grid(True, which='both', linestyle='--', alpha=0.7)

for i, (nome, dados) in enumerate(algoritmos.items()):
    coeffs = np.polyfit(tamanhos, dados, 2)
    equation = f'y = {coeffs[0]:.2e}x² + {coeffs[1]:.2e}x + {coeffs[2]:.2e}'
    ax.text(0.02, 0.90 - 0.05*i, f'{nome}:\n{equation}',
           transform=ax.transAxes, color=cores[nome], 
           fontsize=10, bbox=dict(facecolor='white', 
                                 alpha=0.7, 
                                 edgecolor='none'))

ax.legend(fontsize=11, framealpha=0.9)

plt.tight_layout()
plt.show()