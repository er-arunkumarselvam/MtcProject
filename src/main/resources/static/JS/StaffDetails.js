document.getElementById('staffForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form from submitting the default way

    // Extract form data
    const staffNumber = document.getElementById('staffNumberPojo').value;
    const staffName = document.getElementById('staffNamePojo').value;
    const staffDesignation = document.getElementById('staffDesignationPojo').value;
    const staffMobileNumber = document.getElementById('staffMobileNumberPojo').value;
    const staffMailId = document.getElementById('staffMailIdPojo').value;

    // Basic validation
    if(staffNumber && staffName && staffDesignation && staffMobileNumber && staffMailId) {
        alert('Form submitted successfully!');
        // Here you can handle form data as needed, e.g., sending it to a server
    } else {
        alert('Please fill in all fields.');
    }
});
