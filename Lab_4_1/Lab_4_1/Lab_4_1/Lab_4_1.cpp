// Lab_4_1.cpp 

//Задача 11. 
//На олимпиаду прибыло N человек.Некоторые из них знакомы между собой.
//Можно ли опосредованно перезнакомить их всех между собой ? 
//(Незнакомые люди могут познакомиться только через общего знакомого).

/*Для решения задачи достаточно определить, является ли связным граф, определяемый матрицей смежности,
элементы которой а[i, j] равны 1, если люди с номерами i и j знакомы, и равны 0 иначе. Граф называется связным,
если существует путь между любыми парами его вершин. Понятно, что путь между вершинами i и j в таком графе
и определяет возможную последовательность знакомств, позволяющих познакомить людей с номерами i и j. 

Выберем произвольную вершину в графе и пометим её. Будем выбирать последовательно соседние с ней непомеченные вершины,
применяя к каждой из них ту же самую процедуру. Выход из процедуры будем производить при условии, что вершина
уже помечена.

Если в результате все вершины графа окажутся помеченными, значит граф связен, (имеет одну компоненту связности).
Чтобы определить число компонент связности, достаточно выбрать любую из непомеченных вершин, и повторить
описанные выше действия.

Программа  генерирует случайный граф, который представляется с помощью списков смежности (то есть, для каждой из
вершин указываются её соседи). Вершины графа нумеруются целыми числами, начиная с нуля.

Пользователь выбирает количество вершин и их среднюю степень (mean degree), т.е. среднее число соседей.
После генерации графа вершины маркируются так, что одинаковые цифры соответствуют вершинам, принадлежащим одной
компонене связности.

Если компонента связности одна, всех участников можно опосредованно познакомить друг с другом.
*/

#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <random>

using namespace std;

class Vertex;
typedef vector<Vertex> Graph;

class Vertex
{
	int id;
	int mark;
	vector<int> neighbors;
public:
	Vertex() : id(0), mark(false) {};
	Vertex(int id_) : id(id_), mark(false) {};

	void clear() { id = 0; mark = 0; neighbors.clear(); }
	bool is_neighbour(int vertex_id);

	friend void print_graph(ostream&, const Graph&);
	friend void rand_graph(Graph& G, const int, double);

	friend int mark_connected_vertices(Graph& G, const int mark, const int vert_id);
	friend int first_not_marked_vertex(const Graph& G);
};

bool Vertex::is_neighbour(int vertex_id)
{
	vector<int>::iterator i;
	bool retval = false;
	for (i = neighbors.begin(); i != neighbors.end(); ++i) {
		if (vertex_id == *i) {
			retval = true;
			break;
		}
	}
	return retval;
}

void print_graph(ostream& stream, const Graph& G)
{
	Graph::const_iterator i;
	vector<int>::const_iterator j;

	for (i = G.begin(); i != G.end(); ++i) {
		stream << (*i).id << "/" << (*i).mark << ": ";
		for (j = (*i).neighbors.begin(); j != (*i).neighbors.end(); ++j)
			stream << *j << " ";
		stream << endl;
	}
}


void rand_graph(Graph& G, const int n, double p0 = 0.5)
{
	int i, j;
	for (i = 0; i < n; ++i) {
		Vertex v(i);
		for (j = 0; j < i; ++j) {
			if (G[j].is_neighbour(i))
				v.neighbors.push_back(j);
		}
		for (j = i + 1; j < n; ++j) {
			double p = ((double)rand()) / RAND_MAX;
			if (p < p0) v.neighbors.push_back(j);
		}
		G.push_back(v);
	}
}

int mark_connected_vertices(Graph& G, const int mark, const int vert_id)
{
	vector<int>::iterator j;
	if (vert_id > (G.size() - 1)) return -1; // error
	Vertex& vertex = G[vert_id];
	if (vertex.mark != 0) return 0;
	vertex.mark = mark;
	for (j = vertex.neighbors.begin(); j != vertex.neighbors.end(); ++j)
		if (mark_connected_vertices(G, mark, *j) != 0) return -1;
	return 0;
}

int first_not_marked_vertex(const Graph& G)
{
	Graph::const_iterator i;
	for (i = G.begin(); i != G.end(); ++i) {
		if ((*i).mark == 0) return (*i).id;
	}
	return -1;
}

int mark_components(Graph& G)
{
	int i, mark = 0;
	while ((i = first_not_marked_vertex(G)) >= 0) {
		mark++;
		if (mark_connected_vertices(G, mark, i) < 0) return -1;
	}
	return mark;
}

int main()
{
	Graph G;
	int n, k, comp;
	char cont = 'Y';
	srand(time(0));

	while ((cont == 'Y') || (cont == 'y')) {
		G.clear();
		cout << "Vertices: "; cin >> n;
		cout << "Mean vertex degree: "; cin >> k;
		rand_graph(G, n, (double)k / n);
		if ((comp = mark_components(G)) >= 0) {
			print_graph(cout, G);
			cout << "Connected components:  " << comp << endl;
		}
		else cout << "ERROR" << endl;
		cout << endl;
		cout << "Continue? (y/n): ";
		cin >> cont;
		cout << "-------------------------------" << endl;
	}
	return 0;
}
