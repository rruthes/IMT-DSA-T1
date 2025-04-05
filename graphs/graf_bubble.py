import matplotlib.pyplot as plt
import numpy as np

tamanhos = [100000, 200000, 400000]  # Tamanhos das entradas
medias = [12520460355, 50015803531, 200055352311]  # Médias de operações

plt.figure(figsize=(10, 6))
plt.plot(tamanhos, medias, marker='o', linestyle='-', color='#FF6B6B', 
         linewidth=2.5, markersize=8, markerfacecolor='white', markeredgewidth=2)

for x, y in zip(tamanhos, medias):
    plt.text(x, y, f'{y:.2e}', ha='left', va='bottom', fontsize=10)

plt.title('Crescimento do Número de Operações no Bubble Sort', pad=20, fontsize=14)
plt.xlabel('Tamanho da Entrada (elementos)', fontsize=12)
plt.ylabel('Número Médio de Operações', fontsize=12)

plt.xticks(tamanhos, [f'{x/1000:.0f}k' for x in tamanhos])  # Formata como 100k, 200k, etc.
plt.ticklabel_format(axis='y', style='sci', scilimits=(10,10))
plt.grid(True, linestyle='--', alpha=0.6)

x_fit = np.linspace(min(tamanhos), max(tamanhos), 100)
coeffs = np.polyfit(tamanhos, medias, 2)
y_fit = np.polyval(coeffs, x_fit)
plt.plot(x_fit, y_fit, '--', color='gray', alpha=0.5, label='Tendência quadrática')

plt.legend()
plt.tight_layout()
plt.show()