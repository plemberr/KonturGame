let currentLevel = 1;
let taskId = null;
let timerId = null;
let timeLeft = 60;
let score = 0;

async function loadTask() {
    if (currentLevel > 5) return; // игра завершена

    timeLeft = 60;
    updateTimerDisplay();
    startTimer();

    const response = await fetch(`/get-task?level=${currentLevel}`);
    const data = await response.json();

    taskId = data.taskId;
    const blocks = data.blocks;

    const container = document.getElementById("task-container");
    container.innerHTML = ""; // очистка старых блоков

    blocks.forEach(block => {
        const div = document.createElement("div");
        div.className = "code-block";
        div.textContent = block.text;
        div.dataset.id = block.id;
        div.draggable = true;

        div.addEventListener("dragstart", dragStart);
        div.addEventListener("dragover", dragOver);
        div.addEventListener("drop", drop);

        container.appendChild(div);
    });
}

function startTimer() {
    clearInterval(timerId);
    timerId = setInterval(() => {
        timeLeft--;
        updateTimerDisplay();
        if (timeLeft <= 0) {
            clearInterval(timerId);
            endGame("Время вышло! Игра окончена.");
        }
    }, 1000);
}

function updateTimerDisplay() {
    const timerDiv = document.getElementById("timer");
    if (!timerDiv) {
        const div = document.createElement("div");
        div.id = "timer";
        div.style.fontWeight = "bold";
        div.style.margin = "10px 0";
        document.body.insertBefore(div, document.getElementById("task-container"));
    }
    document.getElementById("timer").textContent = `Осталось времени: ${timeLeft} сек`;
}

function endGame(message) {
    clearInterval(timerId);
    document.querySelector("button").disabled = true;
    document.getElementById("loseScore").textContent = `Ваш результат: ${score} очков`;
    document.getElementById("loseModal").style.display = "flex";
}

function dragStart(e) {
    e.dataTransfer.setData("text/plain", e.target.dataset.id);
    e.dataTransfer.effectAllowed = "move";
    e.target.classList.add("dragging");
}

function dragOver(e) {
    e.preventDefault();
    const dragging = document.querySelector(".dragging");
    const target = e.target.closest(".code-block");

    if (target && target !== dragging) {
        const container = target.parentNode;
        const draggingIndex = [...container.children].indexOf(dragging);
        const targetIndex = [...container.children].indexOf(target);

        if (draggingIndex < targetIndex) {
            container.insertBefore(dragging, target.nextSibling);
        } else {
            container.insertBefore(dragging, target);
        }
    }
}

function drop(e) {
    e.preventDefault();
    const dragging = document.querySelector(".dragging");
    dragging.classList.remove("dragging");
}

async function submitOrder() {
    const blocks = document.querySelectorAll(".code-block");
    const ids = Array.from(blocks).map(block => parseInt(block.dataset.id));

    const response = await fetch("/check", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ taskId, ids })
    });

    const result = await response.json();
    const resultDiv = document.getElementById("result");

    if (result.correct) {
        clearInterval(timerId);
        resultDiv.textContent = "Верно!";
        score += getScoreForLevel(currentLevel);
        currentLevel++;
        if (currentLevel > 5) {
            showWinModal();
        } else {
            document.getElementById("level").textContent = currentLevel;
            setTimeout(() => {
                resultDiv.textContent = "";
                loadTask();
            }, 1000);
        }
    } else {
        timeLeft = Math.max(0, timeLeft - 5); // вычесть 5 секунд, но не ниже 0
        updateTimerDisplay();
        resultDiv.textContent = "Неверно. -5 сек. Попробуйте ещё раз.";
        if (timeLeft <= 0) {
            endGame("Время вышло! Игра окончена.");
        }
    }
}

function getScoreForLevel(level) {
    if (level === 1) return 1000;
    if (level === 2 || level === 3) return 2000;
    if (level === 4 || level === 5) return 2500;
    return 0;
}

function showWinModal() {
    clearInterval(timerId);
    document.getElementById("winScore").textContent = `Ваш результат: ${score} очков`;
    document.getElementById("winModal").style.display = "flex";
}

function startGame() {
    window.location.href = "/game";
}

function restartGame() {
    window.location.href = "/main.html";
}

window.onload = () => {
    if (window.location.pathname === "/game") {
        loadTask();
    }
};


