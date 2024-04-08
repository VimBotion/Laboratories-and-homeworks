import pygame
import math

# Inicializar pygame
pygame.init()

# Definir colores
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)

# Definir el tamaño de la pantalla
WIDTH, HEIGHT = 800, 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Calculadora de Trayectoria de Mouse")

# Reloj para controlar la velocidad de actualización de la pantalla
clock = pygame.time.Clock()

# Posiciones inicial y final del mouse
start_pos = None
end_pos = None

# Lista para almacenar las posiciones anteriores del mouse para calcular la trayectoria
previous_positions = []

# Función para calcular la distancia entre dos puntos
def distance(p1, p2):
    return math.sqrt((p2[0] - p1[0])**2 + (p2[1] - p1[1])**2)

# Función principal
def main():
    global start_pos, end_pos, previous_positions

    running = True
    if pygame.MOUSEBUTTONDOWN:
        start_pos = pygame.mouse.get_pos()
    while running:
        # Manejo de eventos
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.MOUSEBUTTONDOWN:
                if start_pos is None:
                    start_pos = pygame.mouse.get_pos()
                else:
                    end_pos = pygame.mouse.get_pos()

                    # Calcular la distancia total
                    total_distance = 0
                    for i in range(len(previous_positions) - 1):
                        total_distance += distance(previous_positions[i], previous_positions[i + 1])

                    # Calcular la trayectoria
                    trajectory = distance(start_pos, end_pos)

                    # Calcular la velocidad promedio
                    if len(previous_positions) > 0:
                        total_time = pygame.time.get_ticks()
                        speed = total_distance / total_time * 1000  # en píxeles por segundo
                    else:
                        speed = 0

                    # Limpiar la lista de posiciones anteriores
                    previous_positions.clear()

                    # Actualizar la posición inicial
                    start_pos = None

        # Obtener la posición actual del mouse
        current_pos = pygame.mouse.get_pos()

        # Agregar la posición actual a la lista de posiciones anteriores
        previous_positions.append(current_pos)

        # Limpiar la pantalla
        screen.fill(WHITE)

        # Mostrar los puntos de inicio y final si están definidos
        if start_pos is not None:
            pygame.draw.circle(screen, RED, start_pos, 5)
        if end_pos is not None:
            pygame.draw.circle(screen, RED, end_pos, 5)

        # Mostrar información en la pantalla después de que se han establecido dos puntos
        if start_pos is not None and end_pos is not None:
            font = pygame.font.SysFont(None, 30)
            text1 = font.render(f"Distancia Total: {total_distance:.2f} píxeles", True, BLACK)
            text2 = font.render(f"Desplazamiento: {distance(start_pos, end_pos):.2f} píxeles", True, BLACK)
            text3 = font.render(f"Trayectoria: {trajectory:.2f} píxeles", True, BLACK)
            text4 = font.render(f"Velocidad Promedio: {speed:.2f} píxeles/segundo", True, BLACK)
            screen.blit(text1, (20, 20))
            screen.blit(text2, (20, 50))
            screen.blit(text3, (20, 80))
            screen.blit(text4, (20, 110))

        # Actualizar la pantalla
        pygame.display.flip()

        # Controlar la velocidad de actualización
        clock.tick(60)

    pygame.quit()

if __name__ == "__main__":
    main()
