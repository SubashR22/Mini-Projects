document.getElementById('weatherForm').addEventListener('submit', function(event) {
        event.preventDefault(); 
        var cityInput = document.getElementsByName('locationname');
        var errorMsg = document.getElementById('errorMsg');

        if (cityInput.value.trim() === '') {
            errorMsg.style.display = 'block'; // Show error message
        } else {
            errorMsg.style.display = 'none'; // Hide error message
            this.submit(); // Submit the form
        }
        });