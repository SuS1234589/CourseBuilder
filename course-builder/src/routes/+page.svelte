<script lang="ts">
    import SveltyPicker from 'svelty-picker';
  
    let credit = "";
    let required = "";
    let genEds = "";
    let message = "";
    let major = "";
    let startTime: any;
    let endTime : any;

    function handleSubmit(event:SubmitEvent){
    event.preventDefault();
    const intCredit = Number(credit);
    const intRequired = (required != "") ? Number(required) : -1;
    const intGenEds = (genEds != "")? Number(genEds) : -1;
    // this part is not working need to work on this 
    if (intCredit<=0 || intGenEds < 0 || intRequired < 0) message = "Please fill all of them";

    else window.location.href = "/flashcard";
  }

  function SelectedMajor(selectedMajor: string) {
        // Toggle logic: set to selectedMajor if empty, else clear it
        major = (major === selectedMajor) ? '' : selectedMajor;
    }

</script>

<main>
  <h1>Welcome</h1>
  <div class="dropdown">
    <!-- Dropdown Items, only visible if dropdownOpen is true -->
    <div class={`dropdown-content`}>
      
    <p>Select a major </p>
      <button on:click={() => SelectedMajor("Psychology")}>Psychology</button>

      <button on:click={() => SelectedMajor("Computer Science")}>Computer Science</button>

      <button  on:click={() => SelectedMajor("Computer Engineering")}>Computer Engineering</button>

      <button on:click={() => SelectedMajor("Undecided")}>Undecided</button>
      <div class="datepicker-container">
        <p>Start Time</p>
        <SveltyPicker bind:value={startTime} format="hh:ii" displayFormat="HH:ii P"/>
        <p>End time</p>
        <SveltyPicker bind:value={endTime} format="hh:ii" displayFormat="HH:ii P"/>
    </div>

    </div>
  </div>

  <!-- Display selected major -->
  <p>Selected Major: {major}</p>

  <form on:submit={handleSubmit}>
    <div class="form-container">
      <label>
        CREDITS
        <input bind:value={credit} />
      </label>

      <label>
        REQUIRED
        <input bind:value={required} />
      </label>

      <label>
        GEN EDS
        <input bind:value={genEds} />
      </label>

      <button type="submit">Submit</button>
    </div>
  </form>

  <p>{message}</p>
</main>

<style>
  /* Minimalistic styling */

  main {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    font-family: "Arial", sans-serif;
    background-color: #f7f7f7;
    color: #333;
  }

  h1 {
    font-size: 2rem;
    margin-bottom: 1rem;
  }

  button {
    padding: 10px 20px;
    margin: 5px;
    font-size: 1rem;
    border: none;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s ease;
    text-decoration: none;
  }

  button:hover {
    background-color: #0056b3;
  }

  .form-container {
    display: flex;
    align-items: center;
    gap: 20px; /* Adds spacing between the items */
  }

  .form-container label {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .form-container input {
    margin-top: 5px; /* Adds spacing between label and input */
  }


  .datepicker-container {
    margin-top: 20px; /* Optional spacing above the datepicker */
    display: block; /* Ensures the Datepicker takes up a whole line */
  }
</style>
