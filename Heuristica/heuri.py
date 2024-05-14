import math

# Definir las coordenadas de las ciudades
cities = {
    'A': (0, 0),
    'B': (3, 4),
    'C': (6, 1),
    'D': (8, 5),
    'E': (10, 2)
}

# Función para calcular la distancia euclidiana entre dos puntos
def euclidean_distance(city1, city2):
    x1, y1 = cities[city1]
    x2, y2 = cities[city2]
    return math.sqrt((x2 - x1)**2 + (y2 - y1)**2)

# Función para generar todas las posibles rutas entre dos ciudades
def generate_routes(start, end, intermediate_cities):
    routes = []
    for city in intermediate_cities:
        routes.append([start] + city + [end])
    return routes

# Función para calcular la distancia total aproximada de una ruta
def calculate_approximate_distance(route):
    total_distance = 0
    for i in range(len(route) - 1):
        total_distance += euclidean_distance(route[i], route[i+1])
    return total_distance

# Ciudad de inicio y ciudad final
start_city = 'A'
end_city = 'E'

# Ciudades intermedias
intermediate_cities = [['B', 'C', 'D'], ['B', 'D', 'C']]

# Generar todas las posibles rutas
possible_routes = []
for cities_combination in intermediate_cities:
    possible_routes.extend(generate_routes(start_city, end_city, cities_combination))

# Calcular la distancia aproximada de cada ruta
distances = {}
for route in possible_routes:
    distances[tuple(route)] = calculate_approximate_distance(route)

# Seleccionar la ruta con la distancia aproximada más corta
shortest_route = min(distances, key=distances.get)
shortest_distance = distances[shortest_route]

# Mostrar la ruta más corta y su distancia aproximada
print("Ruta más corta:", shortest_route)
print("Distancia aproximada:", shortest_distance)
