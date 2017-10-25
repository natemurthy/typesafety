package main

import (
	"fmt"
	"math"
	"time"
)

type Point struct {
	X float64
	Y float64
}

type Quadratic struct {
	A float64
	B float64
	C float64
}

func (q Quadratic) Solve() Point {
	radicand := math.Pow(q.B, 2) - 4*q.A*q.C
	isImaginary := radicand < 0
	if isImaginary {
		return "undefined"
	}
	radical := math.Sqrt(math.Pow(q.B, 2) - 4*q.A*q.C)
	plus := -q.B + radical
	minus := -q.B - radical
	return Point{plus / (2 * q.A), minus / (2 * q.A)}
}

func SwapCoords(p Point) Point {
	x := p.X
	y := p.Y
	p.X = y
	p.Y = x
	return p
}

func Distance(p1 Point, p2 Point) float64 {
	deltaX := p1.X - p2.X
	deltaY := p1.Y - p2.Y
	return math.Sqrt(math.Pow(deltaX, 2) + math.Pow(deltaY, 2))
}

func main() {
	pt1 := Point{3, 4}
	pt2 := Point{9, 0}
	fmt.Println(Distance(pt1, pt2))
	pt2 = SwapCoords(pt2)

	p := Point{5, 6}
	quad := Quadratic{1, 3, pt2.Y}

	newX := 0.0
	for newX < 8 {
		fmt.Println("Finding new x coord", newX)
		time.Sleep(100 * time.Millisecond)
		newX += 1
	}
	p.X = newX

	fmt.Println(p.X, p.Y)
	q := SwapCoords(p)
	fmt.Println(q.X, q.Y)

	ready := false
	for !ready {
		fmt.Println("Waiting for services to be ready...")
		time.Sleep(1 * time.Second)
		ready = true
	}

	p = quad.Solve()
	fmt.Println(Distance(q, p))
}
