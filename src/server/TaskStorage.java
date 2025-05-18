package server;

import java.util.List;
import java.util.Map;

public class TaskStorage {

    public static final Map<Integer, List<Task>> tasksByLevel = Map.of(
            1, List.of(
                    new Task(1, List.of(
                            new CodeBlock(1, "def hello():"),
                            new CodeBlock(2, "  print(\"Hello, World!\")")
                    )),
                    new Task(2, List.of(
                            new CodeBlock(1, "name = input(\"Enter your name:\")"),
                            new CodeBlock(2, "print(f\"Hello, {name}!\")")
                    )),
                    new Task(3, List.of(
                            new CodeBlock(1, "x, y = 5, 10"),
                            new CodeBlock(2, "print(x + y)")
                    )),
                    new Task(4, List.of(
                            new CodeBlock(1, "for i in range(3):"),
                            new CodeBlock(2, "  print(i)")
                    )),
                    new Task(5, List.of(
                            new CodeBlock(1, "a , b = 3 , 7"),
                            new CodeBlock(2, "if a < b:"),
                            new CodeBlock(3, "  print(\"a less b\")")
                    ))
            ),
            2, List.of(
                    new Task(1, List.of(
                            new CodeBlock(1, "def square(x):"),
                            new CodeBlock(2, "  return x * x")
                    )),
                    new Task(2, List.of(
                            new CodeBlock(1, "nums = [1, 2, 3]"),
                            new CodeBlock(2, "for n in nums:"),
                            new CodeBlock(3, "  print(n)")
                    )),
                    new Task(3, List.of(
                            new CodeBlock(1, "def greet(name):"),
                            new CodeBlock(2, "  print(f\"Hi, {name}!\")")
                    )),
                    new Task(4, List.of(
                            new CodeBlock(1, "x = int(input())"),
                            new CodeBlock(2, "if x % 2 == 0:"),
                            new CodeBlock(3, "  print(\"Even\")"),
                            new CodeBlock(4, "else:"),
                            new CodeBlock(5, "  print(\"Odd\")")
                    )),
                    new Task(5, List.of(
                            new CodeBlock(1, "try:"),
                            new CodeBlock(2, "  value = int('abc')"),
                            new CodeBlock(3, "except ValueError:"),
                            new CodeBlock(4, "  print(\"Invalid input\")")
                    ))
            ),
            3, List.of(
                    new Task(1, List.of(
                            new CodeBlock(1, "student = {\"name\": \"Alice\", \"age\": 20, \"major\": \"CS\"}"),
                            new CodeBlock(2, "for key, value in student.items():"),
                            new CodeBlock(3, "  (print(key, \":\", value)")
                    )),
                    new Task(2, List.of(
                            new CodeBlock(1, "def greet(name=\"Guest\")"),
                            new CodeBlock(2, "  print(\"Hello,\", name + \"!\")"),
                            new CodeBlock(3, "greet(\"Bob\")")
                    )),
                    new Task(3, List.of(
                            new CodeBlock(1, "numbers = [1, 2, 3, 4, 5]"),
                            new CodeBlock(2, "squared_even = list(map(lambda x: x*x if x % 2 == 0 else x, numbers))"),
                            new CodeBlock(3, "print(squared_even)")
                    )),
                    new Task(4, List.of(
                            new CodeBlock(1, "vowels ,letter = \"aeiou\",\"a\""),
                            new CodeBlock(2, "if letter in vowels:"),
                            new CodeBlock(3, "  print(letter, \"vowel\")"),
                            new CodeBlock(4, "else:"),
                            new CodeBlock(5, "  print(letter, \"consosant\")")
                    )),
                    new Task(5, List.of(
                            new CodeBlock(1, "age = 20"),
                            new CodeBlock(2, "is_student = True"),
                            new CodeBlock(3, "status = \"student adult\" if age >= 18 and is_student else \"adult\" if age >= 18 else \"minor\""),
                            new CodeBlock(4, "print(status)")
                    )),
                    new Task(6, List.of(
                            new CodeBlock(1, "import random"),
                            new CodeBlock(2, "colors = [\"red\", \"green\", \"blue\"]"),
                            new CodeBlock(3, "random_color = random.choice(colors)"),
                            new CodeBlock(4, "print(random_color)")
                    )),
                    new Task(7, List.of(
                            new CodeBlock(1, "names = [\"Alice\", \"Bob\", \"Charlie\"]"),
                            new CodeBlock(2, "ages = [20, 22, 21]"),
                            new CodeBlock(3, "for name, age in zip(names, ages):"),
                            new CodeBlock(4, "  print(name, \"is\", age, \"years old\")")
                    ))
            ),
            4, List.of(
                    new Task(1, List.of(
                            new CodeBlock(1, "def factorial(n):"),
                            new CodeBlock(2, "  if n == 0:"),
                            new CodeBlock(3, "      return 1"),
                            new CodeBlock(4, "  else:"),
                            new CodeBlock(5, "      return n * factorial(n-1)"),
                            new CodeBlock(6, "print(factorial(5)")
                    )),

                    new Task(2, List.of(
                            new CodeBlock(1, "try:"),
                            new CodeBlock(2, "  num1 = int(input(\"Enter a number:\"))"),
                            new CodeBlock(3, "  num2 = int(input(\"Enter another number:\"))"),
                            new CodeBlock(4, "  result = num1 / num2"),
                            new CodeBlock(5, "  print(result)"),
                            new CodeBlock(6, "except (ValueError, ZeroDivisionError) as e:"),
                            new CodeBlock(7, "  print(\"Invalid input or division by zero:\", e)")
                    )),
                    new Task(3, List.of(
                            new CodeBlock(1, "class Dog:"),
                            new CodeBlock(2, "  def __init__(self, name, breed):"),
                            new CodeBlock(3, "      self.name = name"),
                            new CodeBlock(4, "      self.breed = breed"),
                            new CodeBlock(5, "  def bark(self):"),
                            new CodeBlock(6, "      print(\"Woof!\")"),
                            new CodeBlock(7, "my_dog = Dog(\"Buddy\", \"Golden Retriever\")"),
                            new CodeBlock(8, "my_dog.bark()")
                    )),
                    new Task(4, List.of(
                            new CodeBlock(1, "numbers = [1, 2, 3, 4, 5, 6]"),
                            new CodeBlock(2, "even_numbers = list(filter(lambda x: x % 2 == 0, numbers))"),
                            new CodeBlock(3, "squared_even = list(map(lambda x: x*x, even_numbers))"),
                            new CodeBlock(4, "print(squared_even)")
                    ))

            ),
            5, List.of(
                    new Task(1, List.of(
                            new CodeBlock(1, "try:"),
                            new CodeBlock(2, "  with open(\"log.txt\", \"a\") as f:"),
                            new CodeBlock(3, "      f.write(\"New log entry\\\\n\")"),
                            new CodeBlock(4, "except IOError as e:"),
                            new CodeBlock(5, "  print(\"Error writing to file:\", e)"),
                            new CodeBlock(6, "finally:"),
                            new CodeBlock(7, "  print(\"Log entry attempted.\")")
                    )),
                    new Task(2, List.of(
                            new CodeBlock(1, "code_string = \"result = 5 + 5\""),
                            new CodeBlock(2, "exec(code_string)"),
                            new CodeBlock(3, "print(result)")

                    )),
                    new Task(3, List.of(
                            new CodeBlock(1, "import json"),
                            new CodeBlock(2, "try:"),
                            new CodeBlock(3, "  with open(\"data.json\", \"r\") as f:"),
                            new CodeBlock(4, "      data = json.load(f)"),
                            new CodeBlock(5, "      print(data)"),
                            new CodeBlock(6, "except FileNotFoundError:"),
                            new CodeBlock(7, "  print(\"data.json not found\")"),
                            new CodeBlock(8, "except json.JSONDecodeError:"),
                            new CodeBlock(9, "  print(\"Invalid JSON format\"")
                    )),
                    new Task(4, List.of(
                            new CodeBlock(1, "import asyncio"),
                            new CodeBlock(2, "async def main():"),
                            new CodeBlock(3, "  await asyncio.sleep(1)"),
                            new CodeBlock(4, "  print(\"Hello, Async!\")"),
                            new CodeBlock(5, "  asyncio.run(main())")
                    ))
            )
    );
}
