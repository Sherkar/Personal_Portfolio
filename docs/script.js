/* =========================
   CONTACT FORM SUBMIT
========================= */
function sendMessage(event) {
  event.preventDefault();

  const responseMsg = document.getElementById("responseMessage");

  const data = {
    name: document.getElementById("name").value.trim(),
    email: document.getElementById("email").value.trim(),
    message: document.getElementById("message").value.trim()
  };

  fetch("/send-message", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  })
    .then(res => res.json())
    .then(() => {
      responseMsg.style.color = "lightgreen";
      responseMsg.textContent = "Message sent successfully!";
      document.getElementById("contactForm").reset();
    })
    .catch(() => {
      responseMsg.style.color = "red";
      responseMsg.textContent = "Please enter valid details.";
    });
}

/* =========================
   MOBILE MENU TOGGLE
========================= */
function toggleMenu() {
  const navLinks = document.getElementById("nav-links");
  navLinks.classList.toggle("active");
}

/* =========================
   BACK TO TOP BUTTON
========================= */
const backToTopBtn = document.getElementById("backToTop");

window.addEventListener("scroll", () => {
  if (window.scrollY > 300) {
    backToTopBtn.style.display = "block";
  } else {
    backToTopBtn.style.display = "none";
  }
});

backToTopBtn.addEventListener("click", () => {
  window.scrollTo({
    top: 0,
    behavior: "smooth"
  });
});
