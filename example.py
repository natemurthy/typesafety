import math
import time


class Point(object):
    
    def __init__(self, _x, _y):
        self._x = _x; self._y = _y
        
    @property
    def x(self):
        return self._x

    @x.setter
    def x(self, value):
        self._x = value
        
    @property
    def y(self):
        return self._y
        
    @y.setter
    def y(self, value):
        self._y = value


class Quadratic(object):

    def __init__(self, a, b, c):
        self.a = int(a); self.b = int(b); self.c = int(c)

    def solve(self):
        radicand = math.pow(self.b,2)-4*self.a*self.c
        is_imaginary = radicand < 0
        if is_imaginary:
            return "undefined"
        radical = math.sqrt(radicand)
        plus  = -self.b + radical
        minus = -self.b - radical
        return Point(plus/(2*self.a), minus/(2*self.a))


def swap_coords(p):
    x = p.x
    y = p.y
    p.x = y
    p.y = x
    return p


def distance(p1, p2):
    delta_x = p1.x - p2.x
    delta_y = p1.y - p2.y
    return math.sqrt(math.pow(delta_x,2) + math.pow(delta_y,2))


if __name__ == '__main__':
    pt1 = Point(3,4)
    pt2 = Point(9,0)
    print(distance(pt1,pt2))
    pt2 = swap_coords(pt2)

    p = Point(5,6)
    quad = Quadratic(1,3,pt2.y)

    new_x = 0
    while new_x < 8:
        print("Finding new x coord %d" % new_x)
        time.sleep(0.1)
        new_x += 1
    p.x = new_x

    print(p.x, p.y)
    q = swap_coords(p)
    print(q.x, q.y)

    ready = False
    while not ready:
        print("Waiting for services to be ready...")
        time.sleep(1)
        ready = True
    
    p = quad.solve()
    print(distance(p,q))
